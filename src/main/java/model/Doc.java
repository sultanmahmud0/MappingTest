package model;

import java.util.List;
import java.util.Map;

public class Doc {

	private String title;
	private List<String> contributors;
	private int eventId;
	private String contentId;
	private long commitId;
	private DocData _data;

	public Aspect getAspect(String aspect) {
		if(_data != null) {
			Map<String, Aspect> aspects = _data.getAspects();
			if(aspects == null) throw new IllegalArgumentException("No aspects (null) in Document!");
			if(aspects.containsKey(aspect)) {
				return aspects.get(aspect);
			}
			throw new IllegalArgumentException("No aspect named " + aspect + 
					" can be found for contentId " + contentId);
		} else {
			throw new IllegalStateException("_data was null"); 
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List< String> getContributors() {
		return contributors;
	}

	public void setContributors(List<String> contributors) {
		this.contributors = contributors;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getContentId() {
		return contentId;
	}


	/**
	 * see updateContentId
	 * @param contentId
	 */
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	/**
	 * contentId is present (from polopoly) both here _and_ in the _data property
	 * in the returned aspect. So calling setContentId here will not update _data. 
	 * 
	 * 
	 * This is not a problem during deserialization since Polopoly sends
	 * contentid in both aspect._data and as metadata pr class =>
	 * this will be ok when deserializing
	 * */
	public void updateContentId(String contentId) {
		this.contentId = contentId;
		if(this._data != null) {
			Aspect aspect = this.getAspect("contentData");
			if(aspect != null)
				aspect.getData().put("contentIdString", contentId);
		}
	}

	public long getCommitId() {
		return commitId;
	}

	public void setCommitId(long commitId) {
		this.commitId = commitId;
	}

	public DocData get_data() {
		return _data;
	}

	public void set_data(DocData _data) {
		this._data = _data;
	} 
}
