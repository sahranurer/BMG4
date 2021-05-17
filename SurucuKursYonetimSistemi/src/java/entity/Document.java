
package entity;

public class Document {
    private String filePath;
    private String fileName;
    private String fileType;
    private Long id;

    public Document(String filePath, String fileName, String fileType) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    

    public Document() {
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    
    
    
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    
}
