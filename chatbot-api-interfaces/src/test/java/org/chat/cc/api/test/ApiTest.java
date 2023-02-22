package org.chat.cc.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * 单元测试
 */
public class ApiTest {

    @Test
    public void query_unanswer_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 查询待回答问题
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51112124128124/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22181cecd907b8a0-0a92a59c20de7f8-26021a51-2073600-181cecd907c73e%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgxY2VjZDkwN2I4YTAtMGE5MmE1OWMyMGRlN2Y4LTI2MDIxYTUxLTIwNzM2MDAtMTgxY2VjZDkwN2M3M2UifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22181cecd907b8a0-0a92a59c20de7f8-26021a51-2073600-181cecd907c73e%22%7D; zsxq_access_token=C5D27676-A9F8-9EC3-6942-43AB72F06234_9BC5A3A0806E24BB; abtest_env=product; zsxqsessionid=cb9432e0d44e673693cb4ed0c42bb6a7");
        get.addHeader("content-type", "application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 该url对应上面待回答问题的topic值
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/214845152415181/answer");
        post.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22181cecd907b8a0-0a92a59c20de7f8-26021a51-2073600-181cecd907c73e%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgxY2VjZDkwN2I4YTAtMGE5MmE1OWMyMGRlN2Y4LTI2MDIxYTUxLTIwNzM2MDAtMTgxY2VjZDkwN2M3M2UifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22181cecd907b8a0-0a92a59c20de7f8-26021a51-2073600-181cecd907c73e%22%7D; zsxq_access_token=C5D27676-A9F8-9EC3-6942-43AB72F06234_9BC5A3A0806E24BB; abtest_env=product; zsxqsessionid=cb9432e0d44e673693cb4ed0c42bb6a7");
        post.addHeader("content-type", "application/json; charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我不吃！！！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
}
