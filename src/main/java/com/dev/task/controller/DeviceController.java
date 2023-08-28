package com.dev.task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.task.entities.Device;
import com.dev.task.services.DeviceService;

@RestController
public class DeviceController {

	@Autowired
	private DeviceService deviceService;
	
	//get all devices handler
	@GetMapping("/devices")
	public ResponseEntity<List<Device>> getDevices(){
		
		List<Device> list = deviceService.getAllDevices();
		
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
		
		return ResponseEntity.of(Optional.of(list));
	}
	
	//get device by id
	@GetMapping("/device/{deviceId}")
	public ResponseEntity<Device> getDevice(@PathVariable("deviceId") int id){
		
		Device device = deviceService.getDeviceById(id);
		
		if(device == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(device)); 
			
	}
	
	//get the number of devices
	@GetMapping("/deviceCount")
	public ResponseEntity<Long> countDevice(){
		
		long count = deviceService.countDevice();
		
		return ResponseEntity.of(Optional.of(count)); 
	}
	
	//new device handler
	@PostMapping("/device")
	public ResponseEntity<Device> addDevice(@RequestBody Device device) {
		
		Device d = null;
		
		try {
		    d = this.deviceService.addDevice(device);
			return ResponseEntity.of(Optional.of(d));
		}catch(Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//delete device handler
	@DeleteMapping("/devices/{deviceId}")
	public ResponseEntity<Device> deleteDevice(@PathVariable("deviceId")int deviceId) {
		
		try {
			
		this.deviceService.deleteDevice(deviceId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//update a device
	@PutMapping("/devices/{deviceId}")
	public ResponseEntity<Device> updateDevice(@RequestBody Device device, @PathVariable("deviceId") int deviceId) {
		
		try {
		this.deviceService.updateDevice(device, deviceId);
		return ResponseEntity.ok().body(device);
		}catch(Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		//return device;
	}
}
