package web.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.member.dao.MemberDao;
import web.member.pojo.MemberBean;
import web.member.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	@Override
	public Integer insertMember(MemberBean mb) {
		return memberDao.insertMember(mb);
	}

	@Override
	public int deleteMemberByKey(Integer id) {
		return memberDao.deleteMemberByKey(id);
	}

	@Override
	public int updateMember(MemberBean mb) {
		return memberDao.updateMember(mb);
	}

	@Override
	public MemberBean selectMemberByKey(Integer id) {
		return memberDao.selectMemberByKey(id);
	}

	@Override
	public List<MemberBean> selectAllMembers() {
		return memberDao.selectAllMembers();
	}
}
