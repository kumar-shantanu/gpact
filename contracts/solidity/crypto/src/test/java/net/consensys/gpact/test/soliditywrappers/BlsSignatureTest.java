package net.consensys.gpact.test.soliditywrappers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.7.0-SNAPSHOT.
 */
@SuppressWarnings("rawtypes")
public class BlsSignatureTest extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610e98806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c8063bbb82d891461003b578063f6e548e91461005c575b600080fd5b6000546100489060ff1681565b604051901515815260200160405180910390f35b61006f61006a366004610d0d565b610071565b005b60006100b287878080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525061015492505050565b905060006100f584848080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152506102c692505050565b90506101398287878080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152508692506103b4915050565b6000805460ff19169115159190911790555050505050505050565b61015c610c47565b60408051600480825260a082019092526000916020820160808036833701905050905060205b815161018f906020610dbb565b81116101af5783810151828201526101a8602082610da3565b9050610182565b50806000815181106101d157634e487b7160e01b600052603260045260246000fd5b602090810291909101015182515280518190600190811061020257634e487b7160e01b600052603260045260246000fd5b602090810291909101015182516001602002015280518190600290811061023957634e487b7160e01b600052603260045260246000fd5b6020026020010151826020015160006002811061026657634e487b7160e01b600052603260045260246000fd5b602002015280518190600390811061028e57634e487b7160e01b600052603260045260246000fd5b602002602001015182602001516001600281106102bb57634e487b7160e01b600052603260045260246000fd5b602002015250919050565b6040805180820182526000808252602082018190528251600280825260608201909452919290919081602001602082028036833701905050905060205b8151610310906020610dbb565b8111610330578381015182820152610329602082610da3565b9050610303565b50604051806040016040528060008152602001600081525091508060008151811061036b57634e487b7160e01b600052603260045260246000fd5b60200260200101518260000181815250508060018151811061039d57634e487b7160e01b600052603260045260246000fd5b602002602001015182602001818152505050919050565b60408051600280825260608201909252600091829190816020015b60408051808201909152600080825260208201528152602001906001900390816103cf5750506040805160028082526060820190925291925060009190602082015b610419610c47565b8152602001906001900390816104115790505090506104378461050d565b8260008151811061045857634e487b7160e01b600052603260045260246000fd5b602002602001018190525061046c856105a5565b8260018151811061048d57634e487b7160e01b600052603260045260246000fd5b60200260200101819052506104a061069c565b816000815181106104c157634e487b7160e01b600052603260045260246000fd5b602002602001018190525085816001815181106104ee57634e487b7160e01b600052603260045260246000fd5b6020026020010181905250610503828261075c565b9695505050505050565b60408051808201909152600080825260208201527f30644e72e131a029b85045b68181585d97816a916871ca8d3c208c16d87cfd4761054b83610b84565b1561056b57505060408051808201909152600080825260208201526105a0565b6040518060400160405280846000015181526020018285602001516105909190610e2c565b61059a9084610dda565b90529150505b919050565b60408051808201825260008082526020808301829052845185820120845180860190955282855290840182905291925b60006105e460ff841685610da3565b905061061b610615604080518082018252600080825260209182015281518083019092526001825260029082015290565b82610b9e565b915061062682610b84565b6106305750610694565b8261063a81610e0c565b935050600a60ff84161061068e5760405162461bcd60e51b815260206004820152601660248201527511985a5b1959081d1bc81b585c081d1bc81c1bda5b9d60521b60448201526064015b60405180910390fd5b506105d5565b949350505050565b6106a4610c47565b50604080516080810182527f198e9393920d483a7260bfb731fb5d25f1aa493335a9e71297e485b7aef312c28183019081527f1800deef121f1e76426a00665e5c4479674322d4f75edadd46debd5cd992f6ed6060830152815281518083019092527f090689d0585ff075ec9e99ad690c3395bc4b313370b38ef355acdadcd122975b82527f12c85ea5db8c6deb4aab71808dcb408fe3d1e7690c43d37b4ce6cc0166fa7daa60208381019190915281019190915290565b600081518351146107a75760405162461bcd60e51b81526020600482015260156024820152742837b4b73a1031b7bab73a1036b4b9b6b0ba31b41760591b6044820152606401610685565b825160006107b6826006610dbb565b905060008167ffffffffffffffff8111156107e157634e487b7160e01b600052604160045260246000fd5b60405190808252806020026020018201604052801561080a578160200160208202803683370190505b50905060005b83811015610b095786818151811061083857634e487b7160e01b600052603260045260246000fd5b602002602001015160000151828260066108529190610dbb565b61085d906000610da3565b8151811061087b57634e487b7160e01b600052603260045260246000fd5b6020026020010181815250508681815181106108a757634e487b7160e01b600052603260045260246000fd5b602002602001015160200151828260066108c19190610dbb565b6108cc906001610da3565b815181106108ea57634e487b7160e01b600052603260045260246000fd5b60200260200101818152505085818151811061091657634e487b7160e01b600052603260045260246000fd5b602090810291909101015151518261092f836006610dbb565b61093a906002610da3565b8151811061095857634e487b7160e01b600052603260045260246000fd5b60200260200101818152505085818151811061098457634e487b7160e01b600052603260045260246000fd5b6020908102919091018101515101518261099f836006610dbb565b6109aa906003610da3565b815181106109c857634e487b7160e01b600052603260045260246000fd5b6020026020010181815250508581815181106109f457634e487b7160e01b600052603260045260246000fd5b602002602001015160200151600060028110610a2057634e487b7160e01b600052603260045260246000fd5b602002015182610a31836006610dbb565b610a3c906004610da3565b81518110610a5a57634e487b7160e01b600052603260045260246000fd5b602002602001018181525050858181518110610a8657634e487b7160e01b600052603260045260246000fd5b602002602001015160200151600160028110610ab257634e487b7160e01b600052603260045260246000fd5b602002015182610ac3836006610dbb565b610ace906005610da3565b81518110610aec57634e487b7160e01b600052603260045260246000fd5b602090810291909101015280610b0181610df1565b915050610810565b50610b12610c6c565b6000602082602086026020860160086107d05a03fa905080610b765760405162461bcd60e51b815260206004820152601960248201527f50616972696e67206f7065726174696f6e206661696c65642e000000000000006044820152606401610685565b505115159695505050505050565b8051600090158015610b9857506020820151155b92915050565b6040805180820190915260008082526020820152610bba610c8a565b83518152602080850151818301526040808301859052805180820182526000808252928101839052908160608560076107d05a03fa915081610c3e5760405162461bcd60e51b815260206004820152601c60248201527f506f696e74206d756c7469706c69636174696f6e206661696c65642e000000006044820152606401610685565b95945050505050565b6040518060400160405280610c5a610ca8565b8152602001610c67610ca8565b905290565b60405180602001604052806001906020820280368337509192915050565b60405180606001604052806003906020820280368337509192915050565b60405180604001604052806002906020820280368337509192915050565b60008083601f840112610cd7578182fd5b50813567ffffffffffffffff811115610cee578182fd5b602083019150836020828501011115610d0657600080fd5b9250929050565b60008060008060008060608789031215610d25578182fd5b863567ffffffffffffffff80821115610d3c578384fd5b610d488a838b01610cc6565b90985096506020890135915080821115610d60578384fd5b610d6c8a838b01610cc6565b90965094506040890135915080821115610d84578384fd5b50610d9189828a01610cc6565b979a9699509497509295939492505050565b60008219821115610db657610db6610e4c565b500190565b6000816000190483118215151615610dd557610dd5610e4c565b500290565b600082821015610dec57610dec610e4c565b500390565b6000600019821415610e0557610e05610e4c565b5060010190565b600060ff821660ff811415610e2357610e23610e4c565b60010192915050565b600082610e4757634e487b7160e01b81526012600452602481fd5b500690565b634e487b7160e01b600052601160045260246000fdfea2646970667358221220342827574a7dc4dc53cbc15727b30de90c4a08731e20d4db14c6bf8bea139b1a64736f6c63430008020033";

    public static final String FUNC_VERIFIED = "verified";

    public static final String FUNC_VERIFYSIGNATURE = "verifySignature";

    @Deprecated
    protected BlsSignatureTest(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BlsSignatureTest(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BlsSignatureTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BlsSignatureTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> verified() {
        final Function function = new Function(FUNC_VERIFIED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public String getRLP_verified() {
        final Function function = new Function(
                FUNC_VERIFIED, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return org.web3j.abi.FunctionEncoder.encode(function);
    }

    public RemoteFunctionCall<TransactionReceipt> verifySignature(byte[] _publicKey, byte[] _message, byte[] _signature) {
        final Function function = new Function(
                FUNC_VERIFYSIGNATURE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(_publicKey), 
                new org.web3j.abi.datatypes.DynamicBytes(_message), 
                new org.web3j.abi.datatypes.DynamicBytes(_signature)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public String getRLP_verifySignature(byte[] _publicKey, byte[] _message, byte[] _signature) {
        final Function function = new Function(
                FUNC_VERIFYSIGNATURE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(_publicKey), 
                new org.web3j.abi.datatypes.DynamicBytes(_message), 
                new org.web3j.abi.datatypes.DynamicBytes(_signature)), 
                Collections.<TypeReference<?>>emptyList());
        return org.web3j.abi.FunctionEncoder.encode(function);
    }

    @Deprecated
    public static BlsSignatureTest load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BlsSignatureTest(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BlsSignatureTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BlsSignatureTest(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BlsSignatureTest load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BlsSignatureTest(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BlsSignatureTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BlsSignatureTest(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BlsSignatureTest> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BlsSignatureTest.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BlsSignatureTest> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BlsSignatureTest.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BlsSignatureTest> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BlsSignatureTest.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BlsSignatureTest> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BlsSignatureTest.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}