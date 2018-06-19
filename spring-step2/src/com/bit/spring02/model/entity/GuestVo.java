package com.bit.spring02.model.entity;

import java.sql.Date;

public class GuestVo {
	private int sabun;
	private String name;
	private Date nalja;
	private int pay;
	
	public GuestVo() {
		// TODO Auto-generated constructor stub
	}

	public GuestVo(int sabun, String name, Date nalja, int pay) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.nalja = nalja;
		this.pay = pay;
	}

	/**
	 * @return the sabun
	 */
	public int getSabun() {
		return sabun;
	}

	/**
	 * @param sabun the sabun to set
	 */
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nalja
	 */
	public Date getNalja() {
		return nalja;
	}

	/**
	 * @param nalja the nalja to set
	 */
	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

	/**
	 * @return the pay
	 */
	public int getPay() {
		return pay;
	}

	/**
	 * @param pay the pay to set
	 */
	public void setPay(int pay) {
		this.pay = pay;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GuestVo [sabun=" + sabun + ", name=" + name + ", nalja="
				+ nalja + ", pay=" + pay + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pay;
		result = prime * result + sabun;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuestVo other = (GuestVo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pay != other.pay)
			return false;
		if (sabun != other.sabun)
			return false;
		return true;
	}
	
	
}
