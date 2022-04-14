package com.example.demostagram.web.dto.user;

import com.example.demostagram.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileDto {
 private boolean PageOwnerState;
 private int imageCount;
 private boolean subscribeState;
 private int subscribeCount;
 private User user;
}
