//package com.idm.app.system.monitor.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.idm.app.system.login.model.IDMUser;
//import com.idm.app.system.login.service.LoginService;
//import com.idm.app.system.monitor.mapper.ServerInfoMapper;
//import com.idm.app.system.monitor.model.ServerInfo;
//import com.idm.app.system.monitor.model.ServerInfoExample;
//import org.apache.commons.lang.StringUtils;
//import org.hyperic.sigar.*;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
///**
// * 服务器监控
// */
//@Controller
//public class ServerMonitorController {
//
//    @Resource
//    ServerInfoMapper serverInfoMapper;
//
//    private Logger logger = Logger.getLogger(ServerMonitorController.class);
//
//    @RequestMapping("/cpu_memory")
//    public String cpu_memory(Model model){
////        ServerInfoExample example = new ServerInfoExample();
////        List<ServerInfo> servers = serverInfoMapper.selectByExample(example);
////        model.addAttribute("servers",servers);
//        return "cpuMemory";
//    }
//
//    @RequestMapping("/rta_service")
//    @ResponseBody
//    public Object login(String username, String password, HttpServletRequest request){
//        JSONObject result = new JSONObject();
//        try{
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//            result.put("cpuUsing",String.format("%.2f",getCpuRatio()*100));
//            result.put("memoryUsing",String.format("%.2f",getUsedMemory()));
//            result.put("cputime",sdf.format(new Date()));
//        }catch (Exception e){
//            logger.error(e);
//            result.put("errorMsg",e.fillInStackTrace());
//        }
//        return result;
//    }
//
//    public double getUsedMemory() throws SigarException {
//        Sigar sigar = new Sigar();
//        Mem mem = sigar.getMem();
//        // 内存总量
//        logger.debug("内存总量:    " + mem.getTotal() / 1024L + "K av");
//        // 当前内存使用量
//        logger.debug("当前内存使用量:    " + mem.getUsed() / 1024L + "K used");
//        // 当前内存剩余量
//        logger.debug("当前内存剩余量:    " + mem.getFree() / 1024L + "K free");
//        Swap swap = sigar.getSwap();
//        // 交换区总量
//        logger.debug("交换区总量:    " + swap.getTotal() / 1024L + "K av");
//        // 当前交换区使用量
//        logger.debug("当前交换区使用量:    " + swap.getUsed() / 1024L + "K used");
//        // 当前交换区剩余量
//        logger.debug("当前交换区剩余量:    " + swap.getFree() / 1024L + "K free");
//
//        return mem.getUsedPercent();
//    }
//
//    /*
//     * 获取cpu使用率
//     * @return
//     * @throws SigarException
//     */
//
//    public double getCpuRatio() throws SigarException {
//        Sigar sigar = new Sigar();
//        CpuInfo infos[] = sigar.getCpuInfoList();
//        CpuPerc cpuList[] = sigar.getCpuPercList();
//        double ratio = 0;
//        if(infos!=null && infos.length>0){
//            CpuInfo info = infos[0];
//            logger.debug("CPU的总量MHz:    " + info.getMhz());// CPU的总量MHz
//            logger.debug("CPU生产商:    " + info.getVendor());// 获得CPU的卖主，如：Intel
//            logger.debug("CPU类别:    " + info.getModel());// 获得CPU的类别，如：Celeron
//            logger.debug("CPU缓存数量:    " + info.getCacheSize());// 缓冲存储器数量
//        }
//        if(cpuList!=null && cpuList.length>0){
//            CpuPerc cpu = cpuList[0];
//            logger.debug("CPU用户使用率:    " + CpuPerc.format(cpu.getUser()));// 用户使用率
//            logger.debug("CPU系统使用率:    " + CpuPerc.format(cpu.getSys()));// 系统使用率
//            logger.debug("CPU当前等待率:    " + CpuPerc.format(cpu.getWait()));// 当前等待率
//            logger.debug("CPU当前错误率:    " + CpuPerc.format(cpu.getNice()));//
//            logger.debug("CPU当前空闲率:    " + CpuPerc.format(cpu.getIdle()));// 当前空闲率
//            logger.debug("CPU总的使用率:    " + CpuPerc.format(cpu.getCombined()));// 总的使用率
//
//            ratio = cpu.getCombined();
//        }
//
//        return ratio;
//    }
//
//    /*
//     * 获取cpu信息
//     * @throws SigarException
//     */
//
//    public void getCpuInfo() throws SigarException {
//        Sigar sigar = new Sigar();
//        CpuInfo infos[] = sigar.getCpuInfoList();
//        CpuPerc cpuList[] = null;
//        cpuList = sigar.getCpuPercList();
//        for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
//            CpuInfo info = infos[i];
//            logger.debug("第" + (i + 1) + "块CPU信息");
//            logger.debug("CPU的总量MHz:    " + info.getMhz());// CPU的总量MHz
//            logger.debug("CPU生产商:    " + info.getVendor());// 获得CPU的卖主，如：Intel
//            logger.debug("CPU类别:    " + info.getModel());// 获得CPU的类别，如：Celeron
//            logger.debug("CPU缓存数量:    " + info.getCacheSize());// 缓冲存储器数量
//            printCpuPerc(cpuList[i]);
//        }
//    }
//
//    /*
//     * 打印cpu信息
//     * @param cpu
//     */
//
//    private void printCpuPerc(CpuPerc cpu) {
//        logger.debug("CPU用户使用率:    " + CpuPerc.format(cpu.getUser()));// 用户使用率
//        logger.debug("CPU系统使用率:    " + CpuPerc.format(cpu.getSys()));// 系统使用率
//        logger.debug("CPU当前等待率:    " + CpuPerc.format(cpu.getWait()));// 当前等待率
//        logger.debug("CPU当前错误率:    " + CpuPerc.format(cpu.getNice()));//
//        logger.debug("CPU当前空闲率:    " + CpuPerc.format(cpu.getIdle()));// 当前空闲率
//        logger.debug("CPU总的使用率:    " + CpuPerc.format(cpu.getCombined()));// 总的使用率
//    }
//}
