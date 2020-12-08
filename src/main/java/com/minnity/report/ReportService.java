package com.minnity.report;
import java.time.Instant;
import java.util.*;


public class ReportService {

  //task 1: Return number of requests that were made for each company. (e.g. companyId -> requestNumber)
  public Map<Integer, Long> calculateNumberOfRequestsPerCompany(List<RequestLog> requestLogs) {
    Map<Integer, Long> requestNumber =new LinkedHashMap<>();
    int count=0;
    int requestTrimThreshold=5000;
    for(RequestLog request:requestLogs){
      if(request.getCreatedTime().toEpochMilli() > requestTrimThreshold){
        requestNumber.put(count, (long) request.getCompanyId() );
        count ++;
      }

    }
    return requestNumber;
  }

  //task 2: Count and return requests per company that finished with an error HTTP response code (>=400)
  public Map<Integer, RequestLog> findRequestsWithError(List<RequestLog> requestLogs) {
    Map<Integer,RequestLog> requestsWithError =new LinkedHashMap<>();
    int count=0;
    for(RequestLog request:requestLogs){
      if(request.getRequestStatus()>=400){
        requestsWithError.put(count,request);
        count ++;
      }
    }
    return requestsWithError;
  }

  //task 3: find and print API (requests path) that on average takes the longest time to process the request.
  public String findRequestPathWithLongestDurationTime(List<RequestLog> requestLogs) {

    long longestDurationTime= 0L;
    for(RequestLog request:requestLogs){
      //find longest process request
      longestDurationTime+=longestDurationTime+request.getRequestDuration();
      long average=longestDurationTime/requestLogs.size();
      if(request.getCreatedTime().isAfter(Instant.ofEpochSecond(average))){
        return  request.getRequestPath();
      }
    }
    return "";
  }
}
