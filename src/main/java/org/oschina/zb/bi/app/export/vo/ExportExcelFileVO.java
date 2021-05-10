package org.oschina.zb.bi.app.export.vo;

import java.util.List;
import java.util.Map;

public class ExportExcelFileVO {

    private String fileName;
    
    private List<Map<String, String>> sheetHeader;
    
    private String dataUri;
    
    private String dataNodeName;
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

	public List<Map<String, String>> getSheetHeader() {
		return sheetHeader;
	}

	public void setSheetHeader(List<Map<String, String>> sheetHeader) {
		this.sheetHeader = sheetHeader;
	}

	public String getDataUri() {
		return dataUri;
	}

	public void setDataUri(String dataUri) {
		this.dataUri = dataUri;
	}

	public String getDataNodeName() {
		return dataNodeName;
	}

	public void setDataNodeName(String dataNodeName) {
		this.dataNodeName = dataNodeName;
	}
}
