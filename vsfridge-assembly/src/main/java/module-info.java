module vsf_assembly {
	requires vsf_core;
	requires static lombok;
	exports ar.net.mgardos.vsfridge.assembly.broker;
	exports ar.net.mgardos.vsfridge.assembly.broker.base;
	exports ar.net.mgardos.vsfridge.assembly.broker.base.state;
	exports ar.net.mgardos.vsfridge.assembly.broker.base.usage;
	exports ar.net.mgardos.vsfridge.assembly.broker.state;
	exports ar.net.mgardos.vsfridge.assembly.broker.usage;
}