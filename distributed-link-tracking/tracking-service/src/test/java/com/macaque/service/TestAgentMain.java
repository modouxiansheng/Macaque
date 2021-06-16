package com.macaque.service;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

public class TestAgentMain {
    public static void main(String[] args) throws Exception {
        //获取当前系统中所有 运行中的 虚拟机
        System.out.println("running JVM start ");
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor vmd : list) {
            //如果虚拟机的名称为 xxx 则 该虚拟机为目标虚拟机，获取该虚拟机的 pid
            //然后加载 agent.jar 发送给该虚拟机
            if (vmd.displayName().endsWith("com.macaque.service.premain.PreMainTest")) {
                VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
                virtualMachine.loadAgent("D:\\my_git\\Macaque\\distributed-link-tracking\\tracking-agent\\target\\tracking-agent-1.0-SNAPSHOT.jar"
                ,"This is Args to the Agent.");
                virtualMachine.detach();
            }
        }
    }
}