package model.dao;

import java.util.List;

import model.pojo.MemberBean;

public interface IMemberDAO {
	public abstract Integer insertMember(MemberBean mb);
	public abstract int deleteMemberByKey(Integer id);
	public abstract int updateMember(MemberBean mb);
	public abstract MemberBean selectMemberByKey(Integer id);
	public abstract List<MemberBean> selectAllMembers();
}