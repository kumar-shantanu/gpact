/*
 * Copyright 2020 ConsenSys Software Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
pragma solidity >=0.7.1;


contract PriceOracle {
    uint256 price;

    address owner;

    constructor () {
        owner = msg.sender;
    }

    /**
     * Set the price. This is a not-lockable location. As such, this must only be set as
     * part of a single-blockchain call.
     *
     * @param _newPrice updated price
     */
    function setPrice(uint256 _newPrice) external {
        require(owner == msg.sender, "Only owner");
        price = _newPrice;
    }

    function getPrice() external view returns (uint256) {
        return price;
    }

}
