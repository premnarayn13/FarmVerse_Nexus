package edu.infosys.FarmVerseApplication.AiService;

public class YeildRequest {
    private String generatedText;

    public YeildRequest() {
    }

    public YeildRequest(String generatedText) {
        this.generatedText = generatedText;
    }

    public String getGeneratedText() {
        return generatedText;
    }

    public void setGeneratedText(String generatedText) {
        this.generatedText = generatedText;
    }
}
