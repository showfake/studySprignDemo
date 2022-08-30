package com.cfs.demo.controller;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * ClassName: SingleResponsibility
 * Description:
 * date: 2022/6/11 19:03
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class SingleResponsibility {

	public static void main(String[] args) {
//		new HttpURLConnection() {
//			@Override
//			public void connect() throws IOException {
//
//			}
//
//			@Override
//			public void disconnect() {
//
//			}
//
//			@Override
//			public boolean usingProxy() {
//				return false;
//			}
//		}.setDefaultUseCaches();
//	}

		class RoadVehicle {
			public void run(String vehicle) {
				System.out.println(vehicle + "");
			}
		}
	}
}
