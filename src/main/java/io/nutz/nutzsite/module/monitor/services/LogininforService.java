package io.nutz.nutzsite.module.monitor.services;

import io.nutz.nutzsite.common.base.Service;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import io.nutz.nutzsite.module.monitor.models.Logininfor;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统访问记录 服务层实现
 * 
 * @author haiming
 * @date 2019-04-18
 */
@IocBean(args = {"refer:dao"})
public class LogininforService extends Service<Logininfor> {
	public LogininforService(Dao dao) {
		super(dao);
	}

	public void cleanLogininfor(){
		List<Logininfor> list =this.query();
		List<String> ids =new ArrayList<>();
		list.forEach(logininfor -> {
			ids.add(logininfor.getId());
		});
		String[] array = new String[ids.size()];
		this.delete(ids.toArray(array));
	}
}
