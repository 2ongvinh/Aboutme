package library;

import model.bean.Users;;

public class PhanQuyen {

	public PhanQuyen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int PqUser(Users us, Users nd) {
		int kq = 0;// không được xóa+sửa ví dụ h xóa thì là trường hợp 2-4.

		if (us.getIdCapbac() == 1) {// th 1
			if (nd.getIdCapbac() == 1 && nd.getIdUsers() == us.getIdUsers())
				kq = 1;// us là ad, us=nd (chỉ sửa) 
			if (nd.getIdCapbac() != 1 )
				kq = 2;// us là  admin và us!=nd(Xóa sửa)
		} else if (us.getIdCapbac() == 2) {// th2
			if (nd.getIdCapbac() == 2 && nd.getIdUsers() == us.getIdUsers())
				kq = 3; // us là  mod và  us=nd (chỉ sửa)
			if (nd.getIdCapbac() == 3)
				kq = 4; // nd là  member, us là  mod (Xóa sửa)
		} else {// th 3
			if (nd.getIdCapbac() == 3 && nd.getIdUsers() == us.getIdUsers())
				kq = 5; // us là  member và  us=nd (chỉ sửa)
		}

		return kq;
	}
}
