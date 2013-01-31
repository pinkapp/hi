package cc.ywxm.service.impl.game;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.BaseInfoDao;
import cc.ywxm.service.game.SendGoldService;

@Transactional
@Service
public class SendGoldServiceImpl implements SendGoldService
{
	@Resource
	private BaseInfoDao baseInfoDao;

	public int send(String receiver, int gold)
	{
		return 0;
	}

	public int send(File receiver, String contentType, int gold)
	{
		return 0;
	}
}
