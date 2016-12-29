package com.spring.serviceImpl;

import java.util.Date;
import java.util.Scanner;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.spring.mapper.FilmMapper;
import com.spring.pojo.Film;
import com.spring.service.FilmService;
@Service
public class FilmServiceImpl implements FilmService{
	@Resource
	private      FilmMapper    filmDao ;
	Scanner input = new Scanner(System.in);
	

	@Override
	public int insert() {
		// TODO Auto-generated method stub
		System.out.println("请输入电影名称");
		String title = input.next();
		System.out.println("请输入电影描述");
		String description =  input.next();
		System.out.println("请输入电影语言ID");
		byte  languageId =  input.nextByte();
		if(languageId > 6){
			System.out.println("语言ID不能大于6！请重输入");
		}
		Film record = new Film();
		record.setTitle(title);
		record.setDescription(description);
		record.setLanguageId(languageId);
		int insertCount = filmDao.insertSelective(record);
		System.out.println("成功插入"+insertCount+"条数据");
		return insertCount;
	}
	

}
