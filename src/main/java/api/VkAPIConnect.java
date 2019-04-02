package api;

import org.apache.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;
import runnerForDOM.RunnerDOM;


public class VkAPIConnect {

    URIBuilder builderForEdit;
    URIBuilder builderForCommit;

    public URIBuilder addCommitOnWall() {
        builderForCommit = СreatorForBuilder.createBuilder(RunnerDOM.getInfo().getMethodPost())
                .setParameter(RunnerDOM.getInfo().getParamMessage(), RunnerDOM.getInfo().getValue());
        return builderForCommit;
    }

    public URIBuilder editCommit() {
        builderForEdit = СreatorForBuilder.createBuilder(RunnerDOM.getInfo().getMethodPost())
                .setParameter(RunnerDOM.getInfo().getParamMessage(), RunnerDOM.getInfo().getValue());
        String postId = СreatorForBuilder.getPostID(builderForEdit);
        СreatorForBuilder.createBuilder(RunnerDOM.getInfo().getMethodEdit())
                .setParameter(RunnerDOM.getInfo().getPostId(), postId)
                .setParameter(RunnerDOM.getInfo().getParamMessage(), RunnerDOM.getInfo().getNewValue());
        return builderForEdit;
    }

    public HttpResponse getHttpResponseForAddCommit() {
        HttpResponse httpResponse = СreatorForBuilder.getResponse(this.builderForCommit);
        return httpResponse;
    }

    public HttpResponse getHttpResponseForEdit() {
        HttpResponse httpResponse = СreatorForBuilder.getResponse(this.builderForEdit);
        return httpResponse;
    }

}