package com.general.utils.docker.container;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.StartContainerCmd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LauncherTest {

    @Test
    public void testLaunchContainer() {
        // Mock DockerClient and its behavior
        DockerClient dockerClientMock = mock(DockerClient.class);
        StartContainerCmd startContainerCmdMock = mock(StartContainerCmd.class);
        CreateContainerResponse createContainerResponse = mock(CreateContainerResponse.class);
        CreateContainerCmd createContainerCmdMock = mock(CreateContainerCmd.class);

        String containerId = "testIdForMockContainer";
        when(createContainerResponse.getId()).thenReturn(containerId);
        
        // Mock the exec method
        when(createContainerCmdMock.exec()).thenReturn(createContainerResponse);
        
        String testImageForMockContainer = "testImage1testVersion1";
        when(dockerClientMock.createContainerCmd(testImageForMockContainer)).thenReturn(createContainerCmdMock);
        when(dockerClientMock.startContainerCmd(containerId)).thenReturn(startContainerCmdMock);

        // Use doNothing() to mock the exec method of StartContainerCmd
        doNothing().when(startContainerCmdMock).exec();
        when(createContainerCmdMock.withName("testContainer")).thenReturn(createContainerCmdMock);
        

        // Call the method under test
        Container container = Launcher.launchContainer(dockerClientMock, "testImage1", "testContainer", "testVersion1");

        // Verify DockerClient interactions
        verify(dockerClientMock).createContainerCmd(testImageForMockContainer);
        verify(createContainerCmdMock).withName("testContainer");
        verify(createContainerCmdMock).exec();

        // Verify behavior
        assertEquals("testImage1", container.getBaseImage());
        assertEquals("testContainer", container.getName());
        assertEquals("testVersion1", container.getVersion());
    }
}
