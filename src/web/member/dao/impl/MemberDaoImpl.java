package web.member.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.member.dao.MemberDao;
import web.member.pojo.MemberBean;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer insertMember(MemberBean mb) {
		Session session = sessionFactory.getCurrentSession();
		mb.setCreateTime(new Timestamp(System.currentTimeMillis()));
		Integer id = (Integer) session.save(mb);
		session.flush();
		return id;
	}
	
	@Override
	public int deleteMemberByKey(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		int result = 0;
		MemberBean mb = new MemberBean();
		mb.setId(id);
		session.delete(mb);
		session.flush();
		return ++result;
	}
	
	@Override
	public int updateMember(MemberBean mb) {
		Session session = sessionFactory.getCurrentSession();
		int result = 0;
		session.update(mb);
		session.flush();
		return ++result;
	}
	
	@Override
	public MemberBean selectMemberByKey(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		MemberBean mb = (MemberBean) session.load(MemberBean.class, id);
		return mb;
	}
	
	@Override
	public List<MemberBean> selectAllMembers() {
		Session session = sessionFactory.getCurrentSession();
		List<MemberBean> memberList = session.createQuery("FROM MemberBean").list();
		return memberList;
	}
}

