package domein;

import static utils.Soort.*;

public class DomeinController //FACADE
{
    private StringValue bedrijfValue;
    private StringValue stageValue;

    public DomeinController() {
        bedrijfValue = new StringValue(BEDRIJF);
        stageValue = new StringValue(STAGE);
    }

    public String getBedrijfId() {
        return bedrijfValue.getValue();
    }

    public String getStageId() {
        return stageValue.getValue();
    }

    public void setBedrijfId(String bedrijfId) {
        bedrijfValue.setValue(bedrijfId);
    }

    public void setStageId(String stageId) {
        stageValue.setValue(stageId);
    }
}