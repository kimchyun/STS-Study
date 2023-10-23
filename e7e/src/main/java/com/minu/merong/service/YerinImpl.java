package com.minu.merong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minu.merong.mapper.YerinMapper;
import com.minu.merong.vo.YerinVO;

@Service
public class YerinImpl implements Yerin{
	
	
	// 서비스impl에서 맵퍼 연결
	@Autowired
	private YerinMapper yerinMapper;
	
	@Override
	public List<YerinVO> listData() {
		return yerinMapper.listData();
	}

	@Override
	public YerinVO oneData(YerinVO yerinVO) {
		return yerinMapper.oneData(yerinVO);
	}

	@Override
	public int insertData(YerinVO yerinVO) {
		return yerinMapper.insertData(yerinVO);
	}

	@Override
	public int updateData(YerinVO yerinVO) {
		return yerinMapper.updateData(yerinVO);
	}

	@Override
	public int deleteData(YerinVO yerinVO) {
		return yerinMapper.deleteData(yerinVO);
	}

}
