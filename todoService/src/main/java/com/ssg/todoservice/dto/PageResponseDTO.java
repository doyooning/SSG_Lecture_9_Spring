package com.ssg.todoservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
    private int page;
    private int size;
    private int total;
    //시작 페이지번호
    private int start;
    //끝 페이지번호
    private int end;
    //이전 페이지의존재여부
    private boolean prev;
    //다음 페이지의존재여부
    private boolean next;
    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO,
                           List<E> dtoList, int total){

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        // 페이지 번호 계산 수식
        /*
        * 화면에 10개씩 페이지 번호를 출력
        * page가 1~10인 경우 -> 시작 페이지 : 1, 마지막 페이지 : 10
        * page가 11~20인 경우 -> 시작 페이지 : 11, 마지막 페이지 : 20
        * last는 마지막 페이지 세트 개수
        * */
        this.end = (int)(Math.ceil(this.page / 10.0)) * 10;
        this.start = this.end - 9;

        int last = (int)(Math.ceil((total/(double)size)));
        this.end = end > last ? last : end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }


}
