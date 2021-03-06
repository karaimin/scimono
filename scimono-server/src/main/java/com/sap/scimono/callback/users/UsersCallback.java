
package com.sap.scimono.callback.users;

import java.util.Optional;

import com.sap.scimono.callback.config.SCIMConfigurationCallback;
import com.sap.scimono.entity.Meta;
import com.sap.scimono.entity.User;
import com.sap.scimono.entity.paging.PageInfo;
import com.sap.scimono.entity.paging.PagedResult;
import com.sap.scimono.entity.patch.PatchBody;

public interface UsersCallback {
  /**
   * @param userName, unique username
   * @return the user with the specified username or null if no such user exists
   */
  User getUserByUsername(final String userName);

  /**
   * @param userId, unique user id
   * @return the user with the specified userId or null if no such user exists
   */
  User getUser(final String userId);

  /**
   * Returns a page of users (limited by {@link SCIMConfigurationCallback#getMaxResourcesPerPage()}),
   * taking into account the specified filter and paging parameters.
   *
   * @param pageInfo parsed paging parameters from the API request
   * @param filter   unparsed filter string from the $filter query parameter
   * @return a page of users or empty page if no users match the filter/paging criteria
   */
  PagedResult<User> getUsers(final PageInfo pageInfo, final String filter);

  /**
   * Creates a user with the provided attributes. The user object must have all mandatory attributes available,
   * including metadata (version, etc.). The returned user must have its id set.
   *
   * @param user
   */
  User createUser(final User user);

  /**
   * +
   * Updates a user with the provided attributes. The user object must have all mandatory attributes available,
   * including metadata (id, new version, etc.).
   *
   * @param user
   */
  void updateUser(final User user);

  /**
   * Updates a user with the provided attributes. The user object must have all mandatory attributes available,
   * including metadata (id, new version, etc.).
   *
   * @param userId
   * @param patchBody
   * @param userMeta
   */
  void patchUser(String userId, PatchBody patchBody, Meta userMeta);

  /**
   * Deletes the user with the specified userId.
   *
   * @param userId
   */
  void deleteUser(final String userId);

  /**
   * Generates a user id for a new user
   *
   * @return a unique user idnetifier
   */
  Optional<String> generateId();
}
