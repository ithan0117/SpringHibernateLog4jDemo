package member.model.dao;

import java.sql.Timestamp;
import java.util.List;

import member.model.pojo.MemberBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class MemberDaoImpl implements MemberDao {
	private SessionFactory sessionFactory;
	
	public MemberDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public Integer insertMember(MemberBean mb) {
		Session session = sessionFactory.getCurrentSession();
		mb.setCreateTime(new Timestamp(System.currentTimeMillis()));
		Integer id = (Integer) session.save(mb);
		session.flush();
		return id;
	}
	
	@Override
	@Transactional
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
	@Transactional
	public int updateMember(MemberBean mb) {
		Session session = sessionFactory.getCurrentSession();
		int result = 0;
		session.update(mb);
		session.flush();
		return ++result;
	}
	
	@Override
	@Transactional
	public MemberBean selectMemberByKey(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		MemberBean mb = (MemberBean) session.load(MemberBean.class, id);
		return mb;
	}
	
	@Override
	@Transactional
	public List<MemberBean> selectAllMembers() {
		Session session = sessionFactory.getCurrentSession();
		List<MemberBean> memberList = session.createQuery("FROM MemberBean").list();
		return memberList;
	}
}

