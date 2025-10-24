package com.ssg.webmvc.todo.service;

import com.ssg.webmvc.todo.dao.TodoDAO;
import com.ssg.webmvc.todo.domain.TodoVO;
import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum TodoService {

    INSTANCE; // 객체의 개수를 결정할 때 사용
    // 현재 INSTANCE가 한 개이므로 서비스 객체 1개만 사용
    // TodoService.INSTANCE 접근, 객체를 하나만 생성(=싱글턴)
    // 어러 컨트롤러들이 TodoService 객체를 통해서 원하는 데이터를 주고받는 구조로 조정
    // 장점 : 정해진 수만큼 객체를 생성 가능
    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        this.dao = new TodoDAO();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    // register(): TodoDTO 파라미터를 받아서 ModelMapper를 통해서  TodoVO 객체로 변환 후
    // dao.insert(todoVO) 를 통해 todoVO 객체를 전달하며 등록기능을 요청

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        dao.insert(todoVO);
    }

//    public List<TodoDTO> getList(){
//        List<TodoDTO> todoDTOs = IntStream.range(0,10).mapToObj(
//                i -> {
//                    TodoDTO dto = new TodoDTO();
//                    dto.setTno((long) i);
//                    dto.setTitle( "Todo...title" + i);
//                    dto.setDueDate(LocalDate.now());
//                    return dto;
//                }
//        ).collect(Collectors.toList());
//        return todoDTOs;
//    }

    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);
        return dto;
    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("voList-----------------");
        log.info(voList);
        List<TodoDTO> dtoList = voList.stream().map(
                vo -> modelMapper.map(vo, TodoDTO.class)
        ).collect(Collectors.toList());

        return dtoList;
    }

    public TodoVO read(Long tno) throws Exception {
        TodoVO todoVO = dao.selectOne(tno);
        log.info("------ read() 호출 ------");
        return todoVO;
    }

    public void update(TodoVO vo) throws Exception {
        dao.updateOne(vo);
        log.info("------ update() 호출 ------");
    }

    public void delete(Long tno) throws Exception {
        dao.delete(tno);
        log.info("------ delete() 호출 ------");
    }
}

