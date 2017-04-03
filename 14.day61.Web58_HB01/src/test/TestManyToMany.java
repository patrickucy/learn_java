package test;

import hibernate.HibernateSessionFactory;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.patrick.entity.Account;
import com.patrick.entity.Administrator;
import com.patrick.entity.Role;
import com.patrick.entity.Service;

public class TestManyToMany {

	/**
	 * association query
	 */
	public static void test1(){
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Administrator admin = (Administrator) session.get(Administrator.class, 3000);
		System.out.println(admin.getAdminCode() +" "+admin.getName());
		Set<Role> roles = admin.getRoles();
		Iterator<Role> it = roles.iterator();
		System.out.println("-------------------------------------------------------------");
		while(it.hasNext()){
			Role role = it.next();
			System.out.println(role.getId()+" "+role.getName());
		}
		session.close();
	}

	public static void test2() {
		String hql = "from admin a join fetch a.roles where a.id=?";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setInteger(0, 3000);
		Administrator admin = (Administrator) query.uniqueResult();
		Set<Role> roles = admin.getRoles();
		Iterator<Role> it = roles.iterator();
		System.out.println("-------------------------------------------------------------");
		while(it.hasNext()){
			Role role = it.next();
			System.out.println(admin.getAdminCode()+ "  " +admin.getName());
		}
		
		session.close();	
	}
	
	/**
	 * 在修改Admin时,自动修改其与role的关系数据, 而并不要求修改role数据本身,因此这里不用写cascade="all"
	 */
	public static void test3(){
		Session session = HibernateSessionFactory.getSession();
		Administrator admin = (Administrator) session.get(Administrator.class, 3000);
		Set<Role> roles = admin.getRoles();
		// 模拟管理员与角色关系维护的行为
		// 移除领导角色,新加管理员角色
		Role role =(Role) session.get(Role.class, 3);
		Role role2 = (Role) session.get(Role.class, 1);
		roles.add(role2);
		
		org.hibernate.Transaction ts = session.beginTransaction();
		session.update(admin);
		ts.commit();
		session.close();
		
	}
}
