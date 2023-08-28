package com.dev.task.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.task.dao.DeviceRepository;
import com.dev.task.entities.Device;

@Component
public class DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;
	//private static List<Device> list = new ArrayList<>();
	
	/*static{
		
		list.add(new Device(12,"n3","v3", "b2",100));
		list.add(new Device(13,"n6","v6", "b6",100));
		list.add(new Device(14,"n4","v4", "b4",100));
		list.add(new Device(15,"n5","v5", "b5",100));
	}*/
	
	//get all the devices
	public List<Device> getAllDevices(){
		
		List<Device> list = (List<Device>)this.deviceRepository.findAll();
		
		return list;
	}
	
	//get device by id
	public Device getDeviceById(int id) {
		
		Device d = null;
		
		try {
			
			d = this.deviceRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	//adding the device
	public Device addDevice(Device d) {
		//list.add(d);
		Device result = deviceRepository.save(d);
		return result;
	}
	
	//delete device
	public void deleteDevice(int deviceId) {
		
		//list = list.stream().filter(device ->device.getId()!= deviceId).
			//	collect(Collectors.toList());
		
		deviceRepository.deleteById(deviceId);
	}
	
	//update the device
	public void updateDevice(Device device, int deviceId) {
		
		/*list = list.stream().map(d->{
			if(d.getId()==deviceId) {
				d.setName(device.getName());
				d.setVersion(device.getVersion());
			}
			return d;
		}).collect(Collectors.toList());*/
		
		device.setId(deviceId);
		deviceRepository.save(device);
	}
	
	//counting the number of devices
	public long countDevice() {
		
		long count = this.deviceRepository.count();
		return count;
	}
}
