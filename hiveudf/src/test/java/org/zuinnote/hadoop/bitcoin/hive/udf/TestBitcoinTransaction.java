/**
* Copyright 2016 ZuInnoTe (Jörn Franke) <zuinnote@gmail.com>
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
**/

package org.zuinnote.hadoop.bitcoin.hive.udf;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.*;

import java.util.List;
import java.util.ArrayList;

/** This is simply for testing the UDF **/
public class TestBitcoinTransaction implements Writable {

	
private IntWritable version;
private BytesWritable inCounter;
private BytesWritable outCounter;
private List<TestBitcoinTransactionInput> listOfInputs;
private List<TestBitcoinTransactionOutput> listOfOutputs;
private IntWritable lockTime;

public TestBitcoinTransaction() {
	this.version=new IntWritable(0);
	this.inCounter=new BytesWritable(new byte[0]);
	this.outCounter=new BytesWritable(new byte[0]);
	this.listOfInputs=new ArrayList<TestBitcoinTransactionInput>();
	this.listOfOutputs=new ArrayList<TestBitcoinTransactionOutput>();
	this.lockTime=new IntWritable(0);
}

public TestBitcoinTransaction(int version, byte[] inCounter, List<TestBitcoinTransactionInput> listOfInputs, byte[] outCounter, List<TestBitcoinTransactionOutput> listOfOutputs, int lockTime) {
	this.version=new IntWritable(version);
	this.inCounter=new BytesWritable(inCounter);
	this.listOfInputs=listOfInputs;
	this.outCounter=new BytesWritable(outCounter);
	this.listOfOutputs=listOfOutputs;
	this.lockTime=new IntWritable(lockTime);
}

public IntWritable getVersion() {
	return this.version;
}

public BytesWritable getInCounter() {
	return this.inCounter;
}

public List<TestBitcoinTransactionInput> getListOfInputs() {
	return this.listOfInputs;
}

public BytesWritable getOutCounter() {
	return this.outCounter;
}

public List<TestBitcoinTransactionOutput> getListOfOutputs() {
	return this.listOfOutputs;
}

public IntWritable getLockTime() {
	return this.lockTime;
}

public void set(TestBitcoinTransaction newTransaction) {
	this.version=newTransaction.getVersion();
	this.inCounter=newTransaction.getInCounter();
	this.listOfInputs=newTransaction.getListOfInputs();
	this.outCounter=newTransaction.getOutCounter();
	this.listOfOutputs=newTransaction.getListOfOutputs();
	this.lockTime=newTransaction.getLockTime();
	
}

/** Writable **/

  @Override
  public void write(DataOutput dataOutput) throws IOException {
    throw new UnsupportedOperationException("write unsupported");
  }

  @Override
  public void readFields(DataInput dataInput) throws IOException {
    throw new UnsupportedOperationException("readFields unsupported");
  }

}
