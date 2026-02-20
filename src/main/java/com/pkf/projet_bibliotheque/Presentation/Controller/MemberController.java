package com.pkf.projet_bibliotheque.Presentation.Controller;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Member.*;
import com.pkf.projet_bibliotheque.Domain.model.Member;
import com.pkf.projet_bibliotheque.Presentation.Dto.Request.MemberRequestDto;
import com.pkf.projet_bibliotheque.Presentation.Dto.Response.MemberResponseDto;
import com.pkf.projet_bibliotheque.Presentation.Mapper.MemberDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final CreateMemberUsecase createMemberUsecase;
    private final ListMemberUseCase listMemberUseCase;
    private final DeleteMemberUseCase deleteMemberUseCase;
    private final UpdateMemberUseCase updateMemberUseCase;
    private final GetMemberUseCase getMemberUseCase;
    private final MemberDtoMapper memberDtoMapper;

    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@Valid @RequestBody MemberRequestDto memberRequestDto) {
        Member member = memberDtoMapper.toDomain(memberRequestDto);
        Member createdBook = createMemberUsecase.createMember(member);
        return ResponseEntity.ok(memberDtoMapper.toDto(createdBook));
    }
    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> getAllMembers() {
        List<Member> members = listMemberUseCase.findAllMembers();
        List<MemberResponseDto> responseDtos = members.stream()
                .map(memberDtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getMemberById(@PathVariable Long id) {
        Member member = getMemberUseCase.findByIdMember(id);
        return ResponseEntity.ok(memberDtoMapper.toDto(member));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable Long id, @Valid @RequestBody MemberRequestDto memberRequestDto) {
        Member member = memberDtoMapper.toDomain(memberRequestDto);
        Member updatedBook = updateMemberUseCase.updateMember(id, member);
        return ResponseEntity.ok(memberDtoMapper.toDto(updatedBook));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMember(@PathVariable Long id) {
        deleteMemberUseCase.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
