package phr.muzima.org.phr.model;

import java.util.Set;

/**
 * Created by HP on 1/10/2018.
 */

public class MuzimaForm {

    private Integer id;
    private String discrtiminator;
    private String modelXml;
    private String modelJson;
    private String metaJson;
    private String form;
    private Set<MuzimaFormTag> tags;
    private Form formDefinition;

    public MuzimaForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiscrtiminator() {
        return discrtiminator;
    }

    public void setDiscrtiminator(String discrtiminator) {
        this.discrtiminator = discrtiminator;
    }

    public String getModelXml() {
        return modelXml;
    }

    public void setModelXml(String modelXml) {
        this.modelXml = modelXml;
    }

    public String getModelJson() {
        return modelJson;
    }

    public void setModelJson(String modelJson) {
        this.modelJson = modelJson;
    }

    public String getMetaJson() {
        return metaJson;
    }

    public void setMetaJson(String metaJson) {
        this.metaJson = metaJson;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Set<MuzimaFormTag> getTags() {
        return tags;
    }

    public void setTags(Set<MuzimaFormTag> tags) {
        this.tags = tags;
    }

    public Form getFormDefinition() {
        return formDefinition;
    }

    public void setFormDefinition(Form formDefinition) {
        this.formDefinition = formDefinition;
    }
}
