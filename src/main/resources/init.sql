CREATE TABLE IF NOT EXISTS job_applications (
    id SERIAL PRIMARY KEY,
    company_name VARCHAR(255) NOT NULL,
    date_applied DATE NOT NULL,
    status VARCHAR(50) NOT NULL CHECK (status IN ('Applied', 'Interview', 'Offer', 'Rejected', 'Withdrawn')),
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert some sample data
INSERT INTO job_applications (company_name, date_applied, status, notes) VALUES
('Google', '2024-01-15', 'Applied', 'Applied for Software Engineer position'),
('Microsoft', '2024-01-20', 'Interview', 'Phone screening scheduled for next week'),
('Amazon', '2024-01-10', 'Rejected', 'Thanks but no thanks email received');