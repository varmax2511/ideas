package com.varun.agent.event.type;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;

import com.varun.agent.corejavautils.event.Event;
import com.varun.agent.corejavautils.event.EventType;

/**
 * <pre>
 * Each event is generated based on the configurations matching it.
 * An event can of many types:
 * - FileEvent : This event will encapsulate the event generated by
 *   a file.
 * - DBEvent : This event is generated via a database query
 * - StreamEvent: This event is generated via a Stream.
 * 
 * </pre>
 * 
 * @author varunjai
 *
 */
public abstract class AgentEvent implements Event {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /**
   * {@link #getEventType()}
   */
  private final EventType eventType;
  /**
   * {@link #getTimeStamp()}
   */
  private final long timeStamp;
  /**
   * {@link #getProperties()}
   */
  private Map<String, Collection<? extends Object>> properties;
  /**
   * {@link #getSize()}
   */
  private long size;
  /**
   * 
   * @param eventType
   *          !null. Type of the event.
   * @param timeStamp
   *          Timestamp when the event was recieved.
   */
  public AgentEvent(EventType eventType, long timeStamp) {
    // null check
    if (eventType == null) {
      throw new IllegalArgumentException("Event Type can be null");
    }
    // agent event check
    if (!EventType.agentEvents.contains(eventType)) {
      throw new IllegalArgumentException("Not an Agent Event Type");
    }

    this.eventType = eventType;
    this.timeStamp = timeStamp;
  }
  /**
   * The properties contained in this {@link AgentEvent}
   * 
   * @return
   */
  public Map<String, Collection<? extends Object>> getProperties() {
    return properties;
  }
  /**
   * 
   * @param properties
   *          can be empty.properties collected for this event.
   */
  public void setProperties(
      Map<String, Collection<? extends Object>> properties) {
    // empty check
    if (MapUtils.isEmpty(properties)) {
      return;
    }

    this.properties = properties;
  }
  /**
   * {@link #getTimeStamp()}
   * 
   * @return
   */
  public EventType getEventType() {
    return eventType;
  }
  /**
   * time stamp when this event was received
   * 
   * @return
   */
  public long getTimeStamp() {
    return timeStamp;
  }
  /**
   * 
   * @return
   */
  public long getSize() {
    return size;
  }
  /**
   * 
   * @param size
   */
  public void setSize(long size) {
    this.size = size;
  }

}