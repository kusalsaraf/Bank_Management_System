
package com.mycompany.bank_management_system;

/**
 *
 * @author Kusal Saraf & Buddhadeb Garai
 */
public class Customer_Details {
    private String name;
	private String accNumber;
	private String address;
	private long balance;
	private String password;
	private String mobileNumber;
    private String addharNumber;
    private String activation;
	
	public Customer_Details(String name,String accNumber,String address,long balance,String password,String mobileNumber,String addharNumber,String activation){
            this.name = name;
            this.accNumber = accNumber;
            this.address = address;
            this.balance = balance;
            this.password = password;
            this.mobileNumber = mobileNumber;
            this.addharNumber = addharNumber;
            this.activation = activation;
        }
        public void setActivation(String activation){
            this.activation = activation;
        }
        public String getAddharNumber(){
            return  addharNumber;
        }
        public String getActivation(){
            return activation;
        }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	} 
	
}
