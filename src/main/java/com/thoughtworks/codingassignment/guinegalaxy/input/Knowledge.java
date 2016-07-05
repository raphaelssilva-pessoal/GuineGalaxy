package com.thoughtworks.codingassignment.guinegalaxy.input;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.codingassignment.guinegalaxy.NumberRomano;

public class Knowledge {
	List<Data> datas;
	List<Information> informations;

	public Knowledge() {
		datas = new ArrayList<Data>();
		informations = new ArrayList<Information>();
	}

	public List<Data> getDatas() {
		return datas;
	}

	public void setDatas(List<Data> datas) {
		this.datas = datas;
	}

	public List<Information> getInformations() {
		return informations;
	}

	public void setInformations(List<Information> informations) {
		this.informations = informations;
	}

	public Data findDataByName(String name) {
		Data dataReturn = null;
		for (Data data : datas) {
			if (data.getName().equals(name)) {
				dataReturn = data;
				break;
			}
		}
		return dataReturn;
	}

	public List<String> processInformations() {
		List<String> informationsStrList = new ArrayList<String>();
		for (Information information : this.informations) {
			try {
				if (information.getDatasName() != null && !information.getDatasName().isEmpty()) {
					int multicador = 0;
					String algoritmo = "";
					
					StringBuilder informationStr = new StringBuilder();
					
					for (String dataStr: information.getDatasName()) {
						Data data = this.findDataByName(dataStr);
						if (data == null) {
							throw new Exception("I have no idea what you are talking about");
						}
						
						if(!data.isMultiplicador()){
							algoritmo+=data.getValue().toString();
						}else{
							multicador+=data.getValue().integerValue();
						}
						
						informationStr.append(dataStr + " ");
					}
					informationStr.append("is ");
					informationStr.append(multicador>0?NumberRomano.integerValue(algoritmo)*multicador:NumberRomano.integerValue(algoritmo));
					if (information.getSuffixValue() != null) {
						informationStr.append(" " + information.getSuffixValue());
					}
					informationsStrList.add(informationStr.toString());

				} else {
					informationsStrList.add("I have no idea what you are talking about");
				}
			} catch (Exception e) {
				informationsStrList.add(e.getMessage());
			}
		}
		return informationsStrList;
	}
}
