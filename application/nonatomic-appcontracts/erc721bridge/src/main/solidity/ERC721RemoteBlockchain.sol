// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

import "../../../../../../common/openzeppelin/src/main/solidity/utils/Context.sol";
import "../../../../../../common/openzeppelin/src/main/solidity/access/AccessControlEnumerable.sol";
import "../../../../../../common/openzeppelin/src/main/solidity/token/ERC721/extensions/ERC721Enumerable.sol";
import "../../../../../../common/openzeppelin/src/main/solidity/token/ERC721/extensions/ERC721Burnable.sol";
import "../../../../../../common/openzeppelin/src/main/solidity/token/ERC721/extensions/ERC721Pausable.sol";

/**
 * This ERC 721 implementation is for the situation when an ERC 721 was issued on another
 * blockchain, and the token has been moved to this blockchain.
 *
 *  - ability for holders to burn (destroy) their tokens
 *  - a miner role can create tokens with specific token ids. This role
 *    should be given to the function call bridge compoenent.
 *  - a pauser role that allows an operator to stop all token transfers
 *
 * This contract uses {AccessControl} to lock permissioned functions using the
 * different roles - head to its documentation for details.
 *
 * The account that deploys the contract will be granted the minter and pauser
 * roles, as well as the default admin role, which will let it grant both minter
 * and pauser roles to other accounts.
 */

abstract contract ERC721RemoteBlockchain is
    Context,
    AccessControlEnumerable,
    ERC721Enumerable,
    ERC721Burnable,
    ERC721Pausable
{
    bytes32 public constant MINTER_ROLE = keccak256("MINTER_ROLE");
    bytes32 public constant PAUSER_ROLE = keccak256("PAUSER_ROLE");

    constructor(
        string memory name,
        string memory symbol,
        address admin,
        address minter,
        address pauser
    ) ERC721(name, symbol) {
        _setupRole(DEFAULT_ADMIN_ROLE, admin);
        _setupRole(MINTER_ROLE, minter);
        _setupRole(PAUSER_ROLE, pauser);
    }

    function _beforeTokenTransfer(
        address from,
        address to,
        uint256 tokenId
    ) internal virtual override(ERC721, ERC721Enumerable, ERC721Pausable) {
        super._beforeTokenTransfer(from, to, tokenId);
    }

    /**
     * @dev See {IERC165-supportsInterface}.
     */
    function supportsInterface(bytes4 interfaceId)
        public
        view
        virtual
        override(AccessControlEnumerable, ERC721, ERC721Enumerable)
        returns (bool)
    {
        return super.supportsInterface(interfaceId);
    }

    /**
     * @dev Pauses all token transfers.
     *
     * See {ERC721Pausable} and {Pausable-_pause}.
     *
     * Requirements:
     *
     * - the caller must have the `PAUSER_ROLE`.
     */
    function pause() public virtual {
        require(
            hasRole(PAUSER_ROLE, _msgSender()),
            "ERC721CrosschainEndPoint: must have pauser role to pause"
        );
        _pause();
    }

    /**
     * @notice Unpauses all token transfers.
     *
     * See {ERC721Pausable} and {Pausable-_unpause}.
     *
     * Requirements:
     *
     * - the caller must have the `PAUSER_ROLE`.
     */
    function unpause() public virtual {
        require(
            hasRole(PAUSER_ROLE, _msgSender()),
            "ERC721CrosschainEndPoint: must have pauser role to unpause"
        );
        _unpause();
    }

    function mint(
        address _recipient,
        uint256 _tokenId,
        bytes memory _data
    ) public virtual;
}
