package com.rajnish.roomdbkotlin


import androidx.room.*

/**
 * Data Access Object for the users table.
 */

@Dao
interface UserDao
{
    @get:Query("SELECT * FROM user")
    val all: List<User>

    @Query("SELECT * FROM user WHERE uid IN (:customersId)")
    fun loadAllByIds(customersId: Array<Int>): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(user: User)

    @Delete
    fun delete(client: User)
}