package person.zxl.boot.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.pagehelper.PageHelper;

import person.zxl.util.mybatis.DemoMapper;
import person.zxl.util.mybatis.PerformanceInterceptor;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class WebConfigure extends WebMvcConfigurerAdapter{
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPlugins(new Interceptor[] { new PerformanceInterceptor(), pageHelperInit() });
		return sessionFactory.getObject();
	}
	
	/**
	 * 初始化分页插件<br/>
	 *
	 * @return Interceptor
	 */
	public Interceptor pageHelperInit() {
		Properties p = new Properties();
		p.setProperty("dialect", "mysql");
		p.setProperty("reasonable", "true");
		p.setProperty("mappers",
				"tk.mybatis.mapper.common.Mapper,person.zxl.util.mybatis.provider.DemoProvider");
		p.setProperty("pageSizeZero", "false");
		p.setProperty("reasonable", "true");
		Interceptor interceptor = new PageHelper();
		interceptor.setProperties(p);
		return interceptor;
	}
	
	@Bean
	public MapperScannerConfigurer getMapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("person.zxl.dao");
		mapperScannerConfigurer.setMarkerInterface(DemoMapper.class);
		return mapperScannerConfigurer;
	}
}
