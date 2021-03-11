package no.hvl.dat159;

import no.hvl.dat159.util.EncodingUtil;
import no.hvl.dat159.util.HashUtil;

/**
 * 
 */
public class CoinbaseTx {
	
	/*
	 * The block number wherein this coinbase tx is located.
	 * This is to ensure unique txIds, see BIP34
	 */
	private int blockHeight; 
	
	/*
	 * The message for this coinbase tx.
	 */
	private String message;
	
	/*
	 * The output for this coinbase tx.
	 */
	private Output output;

	/* --------------------------------------------------------------------- */

	public CoinbaseTx(int blockHeight, String message, String walletAddress) {
		//TODO
		this.blockHeight = blockHeight;
		this.message = message;
		this.output = new Output(1000, walletAddress);
	}
	
	public boolean isValid() {
		//TODO
		if(blockHeight<0 || message == null || output == null) {
			return false;
		}
		return true;
	}

	public String getMessage() {
		return message;
	}

	public Output getOutput() {
		return output;
	}

	/**
	 *	The transaction hash (= a unique txid) as a hexadecimal String. 
	 */
	public String getTxId() {
		//TODO
		return EncodingUtil.bytesToHex(HashUtil.sha256(blockHeight + message));
	}
	
	@Override
	public String toString() {
		return getTxId() + "\n\tmessage    : " + message + "\n\toutput(0)  : " + output;
	}
	
}
