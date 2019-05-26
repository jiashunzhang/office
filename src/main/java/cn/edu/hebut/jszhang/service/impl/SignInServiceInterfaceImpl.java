package cn.edu.hebut.jszhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hebut.jszhang.dao.SignInDaoInterface;
import cn.edu.hebut.jszhang.domain.SignInInfo;
import cn.edu.hebut.jszhang.service.SignInServiceInterface;

/**
 * SignInServiceInterfaceImpl
 */
@Service
public class SignInServiceInterfaceImpl implements SignInServiceInterface {

    @Autowired
    SignInDaoInterface signDao;


    @Override
    public int signIn(SignInInfo signInInfo) {
        return signDao.SignIn(signInInfo);
    }


}