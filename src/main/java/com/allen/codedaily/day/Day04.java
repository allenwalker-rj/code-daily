package com.allen.codedaily.day;

import com.google.common.collect.ImmutableList;
import org.bitcoinj.crypto.*;
import org.bitcoinj.wallet.DeterministicSeed;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import sun.security.provider.SecureRandom;

import java.util.List;


/**
 * @author allen
 * @date 2022/9/20 14:38
 */
public class Day04 {

    private final static ImmutableList<ChildNumber> BIP44_ETH_ACCOUNT_ZERO_PATH =
            ImmutableList.of(new ChildNumber(44, true),new ChildNumber(60,true),
                    ChildNumber.ZERO_HARDENED, ChildNumber.ZERO);

    public static void main(String[] args) throws Exception {
        createWallet();
    }

    public static void createWallet() throws MnemonicException.MnemonicLengthException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] entropy = new byte[DeterministicSeed.DEFAULT_SEED_ENTROPY_BITS / 8];
        secureRandom.engineNextBytes(entropy);

        // 生成12位助记词
        List<String> str = MnemonicCode.INSTANCE.toMnemonic(entropy);

        // 使用助记词生成钱包种子
        byte[] seed = MnemonicCode.toSeed(str, "");

        DeterministicKey masterPrivateKey = HDKeyDerivation.createMasterPrivateKey(seed);

        DeterministicHierarchy deterministicHierarchy = new DeterministicHierarchy(masterPrivateKey);

        DeterministicKey deterministicKey = deterministicHierarchy.deriveChild(BIP44_ETH_ACCOUNT_ZERO_PATH, false,true, new ChildNumber(0));

        byte[] bytes = deterministicKey.getPrivKeyBytes();

        ECKeyPair keyPair = ECKeyPair.create(bytes);
        // 通过公钥生成钱包地址
        String address = Keys.getAddress(keyPair.getPublicKey());

        System.out.println();
        System.out.println("助记词：");
        System.out.println(str);
        System.out.println();
        System.out.println("地址：");
        System.out.println("0x" + address);
        System.out.println();
        System.out.println("私钥：");
        System.out.println("0x" + keyPair.getPrivateKey().toString(16));
        System.out.println();
        System.out.println("公钥：");
        System.out.println(keyPair.getPublicKey().toString(16));

    }
}
