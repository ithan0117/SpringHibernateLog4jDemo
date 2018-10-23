package web.member.service;

import java.util.List;

import web.member.pojo.MemberBean;

public interface MemberService {

	public abstract Integer insertMember(MemberBean mb);

	public abstract int deleteMemberByKey(Integer id);

	public abstract int updateMember(MemberBean mb);

	public abstract MemberBean selectMemberByKey(Integer id);

	public abstract List<MemberBean> selectAllMembers();

}