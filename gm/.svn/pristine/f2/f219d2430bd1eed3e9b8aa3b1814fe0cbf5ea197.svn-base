package cc.ywxm.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HeadByteArray {
	private int aid;
	private short type;
	private short flag;

	public HeadByteArray() {
		super();
	}

	public byte[] toByteArray() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		CPPOutputStream cppOutputStream = new CPPOutputStream(out);
		try {
			cppOutputStream.writeInt(aid);
			cppOutputStream.writeShort(type);
			cppOutputStream.writeShort(flag);
			cppOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out.toByteArray();
	}

	public String toBinaryString() {
		byte[] byteArray = toByteArray();
		StringBuffer sb = new StringBuffer();
		for (byte c : byteArray) {
			//System.out.println(c);
			sb.append(Integer.toBinaryString(c));
		}
		return sb.toString();
	}

	public HeadByteArray(int aid, short type, short flag) {
		super();
		this.aid = aid;
		this.type = type;
		this.flag = flag;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public short getFlag() {
		return flag;
	}

	public void setFlag(short flag) {
		this.flag = flag;
	}
}
