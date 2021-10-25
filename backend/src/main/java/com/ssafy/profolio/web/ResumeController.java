package com.ssafy.profolio.web;

import com.ssafy.profolio.exception.BaseException;
import com.ssafy.profolio.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequiredArgsConstructor
@RestController
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

}
