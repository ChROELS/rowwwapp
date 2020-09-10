package be.intecbrussel.views;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public abstract class AbstractCsvView extends AbstractView {
    //properties
    private static final String CONTENT_TYPE = "text/csv";
    private String url;
    //constructor
    public AbstractCsvView() {
        setContentType(CONTENT_TYPE);
    }
    //setter
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }
    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType(getContentType());
        buildCsvDocument(map, httpServletRequest, httpServletResponse);
    }
    protected abstract void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
