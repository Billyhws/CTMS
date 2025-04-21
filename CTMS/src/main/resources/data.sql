INSERT INTO agency (name, email, phone, address, password)
VALUES
    ('islem', 'sf@gmai.com', '5124151', 'ali ali', 'sdfkj'),
    ('islem', 'ssf@gmai.com', '512414551', 'ali ali', 'sdfkj'),
    ('islem', 'sfd@gmai.com', '512124151', 'ali ali', 'sdfkj'),
    ('islem', 'sff@gmai.com', '513224151', 'ali ali', 'sdfkj'),
    ('ExploreNow Travels', 'contact@explorenow.com', '9876543210', '123 Adventure Lane, Delhi', 'hashed_pwd_1'),
    ('Wanderlust Tours', 'info@wanderlust.com', '9123456780', '88 Explore St, Mumbai', 'hashed_pwd_2');

INSERT INTO Trip (agency_id, location, price, itinerary, available_slots, start_trip_date)
VALUES
    (1, 'Manali', 12000.00, 'Day 1: Sightseeing, Day 2: Trekking', 15, '2025-05-20'),
    (5, 'Goa', 18000.00, 'Beach party and water sports', 20, '2025-06-10'),
    (6, 'Jaipur', 9500.00, 'City Palace, Hawa Mahal, Amer Fort', 10, '2025-07-15');
