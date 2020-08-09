module vsf_core {
	//requires static org.slf4j;
	requires org.apache.logging.log4j;
	requires static lombok;
	requires io.reactivex.rxjava2;
	exports ar.net.mgardos.vsfridge.core;
	exports ar.net.mgardos.vsfridge.core.component;
	exports ar.net.mgardos.vsfridge.core.ensemble;
}