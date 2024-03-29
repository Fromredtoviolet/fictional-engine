package kr.co.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.vo.AccountVO;

public class OracleConnection {

	public static SqlSession getSqlSession() {
		SqlSession sess = null;
		
		try(InputStream is = Resources.getResourceAsStream("mybatis/mybatis-config.xml")) {
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			sess = factory.openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sess;
	}
	public static void main(String[] args) {
		SqlSession sess = OracleConnection.getSqlSession();
		String result = sess.selectOne("test.hello");
		System.out.println(result);
		
		List<AccountVO> reqAccounts = sess.selectList("test.reqAccount");
		for(AccountVO d: reqAccounts) {
			System.out.println(d);
		}
	}

}
