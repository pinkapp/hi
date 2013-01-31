package cc.ywxm.service.impl.game;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.BaseInfoDao;
import cc.ywxm.service.game.SendLetterService;

@Transactional
@Service
public class SendLetterServiceImpl implements SendLetterService
{
	@Resource
	private BaseInfoDao baseInfoDao;

	public int send(String receiver, String subject, String content)
	{
		return 0;
	}

	public int send(File receiver, String contentType, String subject,
			String content)
	{
		return 0;
	}

	

}
