module vsf_emu {
	requires vsf_core;
	requires vsf_assembly;
	requires org.apache.logging.log4j;
	requires static lombok;
	requires spring.beans;
	requires spring.context;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.web;
	requires spring.webmvc;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.controls;
	exports ar.net.mgardos.vsfridge.emu.product;
	exports ar.net.mgardos.vsfridge.emu.sample;
	exports ar.net.mgardos.vsfridge.emu.web.spring;
	opens ar.net.mgardos.vsfridge.emu.web.spring to spring.core;
}