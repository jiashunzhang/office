package cn.edu.hebut.jszhang.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.hebut.jszhang.dao.SignInDaoInterface;
import cn.edu.hebut.jszhang.domain.SignInInfo;

/**
 * SignDaoInterfaceImpl
 */
@Repository
public class SignDaoInterfaceImpl implements SignInDaoInterface {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int SignIn(SignInInfo signInInfo) {
        int result = jdbc.update("insert into sign_ins(sno,stime,saddress) values(?,now(),?)", signInInfo.getSno(),signInInfo.getSaddress());
        return result;
    }

    
}